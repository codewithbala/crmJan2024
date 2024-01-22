import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CandidateBDViewComponent } from './candidate-bdview.component';

describe('CandidateBDViewComponent', () => {
  let component: CandidateBDViewComponent;
  let fixture: ComponentFixture<CandidateBDViewComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [CandidateBDViewComponent]
    });
    fixture = TestBed.createComponent(CandidateBDViewComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
