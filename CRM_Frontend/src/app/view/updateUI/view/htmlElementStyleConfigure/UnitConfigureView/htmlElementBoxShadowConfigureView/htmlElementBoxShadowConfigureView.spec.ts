import { ComponentFixture, TestBed } from '@angular/core/testing';

import { HtmlElementBoxShadowConfigureView } from './htmlElementBoxShadowConfigureView';

describe('HtmlElementBoxShadowConfigureViewComponent', () => {
  let component: HtmlElementBoxShadowConfigureView;
  let fixture: ComponentFixture<HtmlElementBoxShadowConfigureView>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [HtmlElementBoxShadowConfigureView]
    });
    fixture = TestBed.createComponent(HtmlElementBoxShadowConfigureView);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
