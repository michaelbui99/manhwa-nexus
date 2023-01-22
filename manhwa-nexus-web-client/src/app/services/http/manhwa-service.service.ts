import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { lastValueFrom } from 'rxjs';
import { Manhwa } from 'src/app/models/manhwa';
import { ConfigService } from '../config-service.service';

@Injectable({
    providedIn: 'root',
})
export class ManhwaService {
    constructor(private _httpClient: HttpClient, private _configService: ConfigService) {}

    async getManhwas(): Promise<Manhwa[]> {
        const url = (await this._configService.getConfig()).api.server + 'manhwas';
        return lastValueFrom(this._httpClient.get<Manhwa[]>(url));
    }
}
