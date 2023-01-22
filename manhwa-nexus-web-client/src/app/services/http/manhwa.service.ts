import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { lastValueFrom } from 'rxjs';
import { Manhwa } from 'src/app/models/manhwa';
import { ConfigService } from '../config.service';

@Injectable({
    providedIn: 'root',
})
export class ManhwaService {
    private _baseUrl = '';
    constructor(private _httpClient: HttpClient, private _configService: ConfigService) {
        this.init();
    }

    async init(): Promise<any> {
        this._baseUrl = (await this._configService.getConfig()).api.server;
    }

    async getManhwas(): Promise<Manhwa[]> {
        const url = `${this._baseUrl}/manhwas`;
        return lastValueFrom(this._httpClient.get<Manhwa[]>(url));
    }

    async getGenres(): Promise<string[]> {
        const url = `${this._baseUrl}/genres`;
        return lastValueFrom(this._httpClient.get<string[]>(url));
    }
}
