import { ComponentFixture, TestBed } from '@angular/core/testing';

import { HtmlElementBoxPositionConfigureView } from './htmlElementBoxPositionConfigureView';

describe('HtmlElementBoxPositionConfigureViewComponent', () => {
  let component: HtmlElementBoxPositionConfigureView;
  let fixture: ComponentFixture<HtmlElementBoxPositionConfigureView>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [HtmlElementBoxPositionConfigureView]
    });
    fixture = TestBed.createComponent(HtmlElementBoxPositionConfigureView);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
