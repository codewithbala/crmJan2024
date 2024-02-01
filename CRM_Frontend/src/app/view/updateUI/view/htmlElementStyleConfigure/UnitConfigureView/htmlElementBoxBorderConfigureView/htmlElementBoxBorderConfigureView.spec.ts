import { ComponentFixture, TestBed } from '@angular/core/testing';

import { HtmlElementBoxBorderConfigureView } from './htmlElementBoxBorderConfigureView';

describe('HtmlElementBoxBorderConfigureViewComponent', () => {
  let component: HtmlElementBoxBorderConfigureView;
  let fixture: ComponentFixture<HtmlElementBoxBorderConfigureView>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [HtmlElementBoxBorderConfigureView]
    });
    fixture = TestBed.createComponent(HtmlElementBoxBorderConfigureView);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
