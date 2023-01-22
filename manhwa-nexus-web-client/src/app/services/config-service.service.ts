import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { lastValueFrom } from 'rxjs';

export interface ClientConfig {
    api: ApiConfig;
}

export interface ApiConfig {
    server: string;
    gateway: string;
}

@Injectable({
    providedIn: 'root',
})
export class ConfigService {
    private CONFIG_FILE = 'client-config.json';
    private _configLoaded = false;
    private _config: ClientConfig = null;

    constructor(private _httpClient: HttpClient) {}

    async loadConfig(): Promise<any> {
        if (this._configLoaded) {
            return;
        }

        const config: ClientConfig = await lastValueFrom<ClientConfig>(
            this._httpClient.get<ClientConfig>(`./assets/${this.CONFIG_FILE}`)
        );

        if (!config) {
            console.warn('Failed to load configuration. No configurations are set');
            return;
        }

        this._config = config;
        this._configLoaded = true;
        console.info('loaded configurations: ', this._config);
    }

    async getConfig(): Promise<ClientConfig> {
        if (!this._configLoaded) {
            await this.loadConfig();
        }

        if (!this._configLoaded) {
            throw new Error('no configurations found');
        }

        return this._config;
    }
}
