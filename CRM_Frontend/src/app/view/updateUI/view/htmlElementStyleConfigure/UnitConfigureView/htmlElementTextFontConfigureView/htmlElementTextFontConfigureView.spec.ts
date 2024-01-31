import { ComponentFixture, TestBed } from '@angular/core/testing';

import { HtmlElementTextConfigureView } from './htmlElementTextConfigureView';

describe('HtmlElementTextConfigureViewComponent', () => {
  let component: HtmlElementTextConfigureView;
  let fixture: ComponentFixture<HtmlElementTextConfigureView>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [HtmlElementTextConfigureView]
    });
    fixture = TestBed.createComponent(HtmlElementTextConfigureView);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
