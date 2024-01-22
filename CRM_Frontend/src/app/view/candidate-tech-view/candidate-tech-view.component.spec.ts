import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CandidateTechViewComponent } from './candidate-tech-view.component';

describe('CandidateTechViewComponent', () => {
  let component: CandidateTechViewComponent;
  let fixture: ComponentFixture<CandidateTechViewComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [CandidateTechViewComponent]
    });
    fixture = TestBed.createComponent(CandidateTechViewComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
