import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ViewAllSubmissionsComponent } from './view-all-submissions.component';

describe('ViewAllSubmissionsComponent', () => {
  let component: ViewAllSubmissionsComponent;
  let fixture: ComponentFixture<ViewAllSubmissionsComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [ViewAllSubmissionsComponent]
    });
    fixture = TestBed.createComponent(ViewAllSubmissionsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
