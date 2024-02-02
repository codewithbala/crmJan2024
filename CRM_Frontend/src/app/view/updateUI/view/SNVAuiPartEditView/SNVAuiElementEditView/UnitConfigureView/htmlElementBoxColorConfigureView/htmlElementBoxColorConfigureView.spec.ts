import { ComponentFixture, TestBed } from '@angular/core/testing';

import { HtmlElementBoxColorConfigureView } from './htmlElementBoxColorConfigureView';

describe('HtmlElementBoxBackGroundConfigureViewComponent', () => {
  let component: HtmlElementBoxColorConfigureView;
  let fixture: ComponentFixture<HtmlElementBoxColorConfigureView>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [HtmlElementBoxColorConfigureView]
    });
    fixture = TestBed.createComponent(HtmlElementBoxColorConfigureView);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
