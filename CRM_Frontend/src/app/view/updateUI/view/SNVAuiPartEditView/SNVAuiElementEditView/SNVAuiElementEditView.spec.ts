import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SNVAuiElementEditView } from './SNVAuiElementEditView';

describe('HtmlElementConfigureComponent', () => {
  let component: SNVAuiElementEditView;
  let fixture: ComponentFixture<SNVAuiElementEditView>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [SNVAuiElementEditView]
    });
    fixture = TestBed.createComponent(SNVAuiElementEditView);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
