import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { FinanceTileComponent } from './finance-tile.component';

describe('FinanceTileComponent', () => {
  let component: FinanceTileComponent;
  let fixture: ComponentFixture<FinanceTileComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ FinanceTileComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(FinanceTileComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
