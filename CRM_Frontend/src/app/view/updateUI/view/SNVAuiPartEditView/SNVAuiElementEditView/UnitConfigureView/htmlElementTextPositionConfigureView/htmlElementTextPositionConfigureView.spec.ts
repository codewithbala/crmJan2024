import { ComponentFixture, TestBed } from '@angular/core/testing';

import { HtmlElementTextPositionConfigureView } from './htmlElementTextPositionConfigureView';

describe('HtmlElementTextPositionConfigureViewComponent', () => {
  let component: HtmlElementTextPositionConfigureView;
  let fixture: ComponentFixture<HtmlElementTextPositionConfigureView>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [HtmlElementTextPositionConfigureView]
    });
    fixture = TestBed.createComponent(HtmlElementTextPositionConfigureView);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
