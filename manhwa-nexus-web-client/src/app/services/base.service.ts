import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { sleep } from '../util/sleep';
import { ConfigService } from './config.service';

@Injectable({
    providedIn: 'root',
})
export class BaseService {
    private _baseUrl = '';
    constructor(protected _httpClient: HttpClient, protected _configService: ConfigService) {
        this._ensureConfigLoaded();
    }

    private async _init(): Promise<any> {
        this._baseUrl = (await this._configService.getConfig()).api.server;
    }

    protected async _ensureConfigLoaded() {
        if (this._configService.configLoaded) {
            return;
        }

        while (!this._configService.configLoaded) {
            await this._init();
            await sleep(1000);

            if (this._configService.configLoaded) {
                break;
            }
        }
    }

    protected async getBaseUrl(): Promise<string> {
        await this._ensureConfigLoaded();
        return this._baseUrl;
    }
}
