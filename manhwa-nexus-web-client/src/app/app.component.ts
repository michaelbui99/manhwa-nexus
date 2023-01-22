import { Component, OnInit } from '@angular/core';
import { ConfigService } from './services/config.service';

@Component({
    selector: 'app-root',
    templateUrl: './app.component.html',
    styleUrls: ['./app.component.scss'],
})
export class AppComponent implements OnInit {
    constructor(private _configService: ConfigService) {}
    async ngOnInit(): Promise<void> {
        await this._configService.loadConfig();
    }
    title = 'manhwa-nexus-web-client';
}
