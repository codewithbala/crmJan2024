import { ComponentFixture, TestBed } from '@angular/core/testing';

import { HtmlElementTextShadowConfigureView } from './htmlElementTextShadowConfigureView';

describe('HtmlElementTextShadowConfigureViewComponent', () => {
  let component: HtmlElementTextShadowConfigureView;
  let fixture: ComponentFixture<HtmlElementTextShadowConfigureView>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [HtmlElementTextShadowConfigureView]
    });
    fixture = TestBed.createComponent(HtmlElementTextShadowConfigureView);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
