import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CadidateRecruiterDetailViewComponent } from './cadidate-recruiter-detail-view.component';

describe('CadidateRecruiterDetailViewComponent', () => {
  let component: CadidateRecruiterDetailViewComponent;
  let fixture: ComponentFixture<CadidateRecruiterDetailViewComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [CadidateRecruiterDetailViewComponent]
    });
    fixture = TestBed.createComponent(CadidateRecruiterDetailViewComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
