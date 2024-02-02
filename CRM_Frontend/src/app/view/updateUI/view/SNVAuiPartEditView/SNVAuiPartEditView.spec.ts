import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SNVAuiPartEditView } from './SNVAuiPartEditView';

describe('SNVAuiPartEditViewComponent', () => {
  let component: SNVAuiPartEditView;
  let fixture: ComponentFixture<SNVAuiPartEditView>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [SNVAuiPartEditView]
    });
    fixture = TestBed.createComponent(SNVAuiPartEditView);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
