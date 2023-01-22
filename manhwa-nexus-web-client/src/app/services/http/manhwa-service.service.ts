import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { ConfigService } from '../config-service.service';

@Injectable({
    providedIn: 'root',
})
export class ManhwaService {
    constructor(private _httpClient: HttpClient, private _configService: ConfigService) {
        this._configService.loadConfig();
    }
}
