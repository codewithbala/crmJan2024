import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SNVAuiPartPreView } from './SNVAuiPartPreView';

describe('HtmlElementPreViewComponent', () => {
  let component: SNVAuiPartPreView;
  let fixture: ComponentFixture<SNVAuiPartPreView>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [SNVAuiPartPreView]
    });
    fixture = TestBed.createComponent(SNVAuiPartPreView);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
