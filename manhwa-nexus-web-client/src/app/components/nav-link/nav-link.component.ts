import { Component, Input, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
    selector: 'app-nav-link',
    templateUrl: './nav-link.component.html',
    styleUrls: ['./nav-link.component.scss'],
})
export class NavLinkComponent implements OnInit {
    @Input()
    navLink: NavLink;

    constructor(private _router: Router) {}

    ngOnInit(): void {}

    async onClick() {
        console.log(this._router);
        await this._router.navigateByUrl(this.navLink.navigatePath);
    }
}

export interface NavLink {
    navigatePath: string;
    displayText: string;
    selected: boolean;
}
