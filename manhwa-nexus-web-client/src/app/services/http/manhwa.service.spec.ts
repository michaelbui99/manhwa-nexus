import { TestBed } from '@angular/core/testing';

import { ManhwaService } from './manhwa-service.service';

describe('ManhwaServiceService', () => {
    let service: ManhwaService;

    beforeEach(() => {
        TestBed.configureTestingModule({});
        service = TestBed.inject(ManhwaService);
    });

    it('should be created', () => {
        expect(service).toBeTruthy();
    });
});
