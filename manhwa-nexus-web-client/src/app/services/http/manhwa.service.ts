import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { lastValueFrom } from 'rxjs';
import { Manhwa } from 'src/app/models/manhwa';
import { BaseService } from '../base.service';
import { ConfigService } from '../config.service';

@Injectable({
    providedIn: 'root',
})
export class ManhwaService extends BaseService {
    constructor(httpClient: HttpClient, configService: ConfigService) {
        super(httpClient, configService);
    }

    async getManhwas(): Promise<Manhwa[]> {
        const url = `${await this.getBaseUrl()}/manhwas`;
        return lastValueFrom(this._httpClient.get<Manhwa[]>(url));
    }

    async getGenres(): Promise<string[]> {
        const url = `${await this.getBaseUrl()}/genres`;
        return lastValueFrom(this._httpClient.get<string[]>(url));
    }
}
