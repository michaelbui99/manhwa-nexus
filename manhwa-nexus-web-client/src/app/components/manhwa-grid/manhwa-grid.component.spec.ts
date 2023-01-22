import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ManhwaGridComponent } from './manhwa-grid.component';

describe('ManhwaGridComponent', () => {
  let component: ManhwaGridComponent;
  let fixture: ComponentFixture<ManhwaGridComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ManhwaGridComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ManhwaGridComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
