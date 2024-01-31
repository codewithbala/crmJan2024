import { ComponentFixture, TestBed } from '@angular/core/testing';

import { HtmlElementPreView } from './htmlElementPreView';

describe('HtmlElementPreViewComponent', () => {
  let component: HtmlElementPreView;
  let fixture: ComponentFixture<HtmlElementPreView>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [HtmlElementPreView]
    });
    fixture = TestBed.createComponent(HtmlElementPreView);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
