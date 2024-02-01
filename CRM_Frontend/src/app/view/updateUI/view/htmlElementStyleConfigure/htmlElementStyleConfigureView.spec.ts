import { ComponentFixture, TestBed } from '@angular/core/testing';

import { HtmlElementStyleConfigureView } from './htmlElementStyleConfigureView';

describe('HtmlElementConfigureComponent', () => {
  let component: HtmlElementStyleConfigureView;
  let fixture: ComponentFixture<HtmlElementStyleConfigureView>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [HtmlElementStyleConfigureView]
    });
    fixture = TestBed.createComponent(HtmlElementStyleConfigureView);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
