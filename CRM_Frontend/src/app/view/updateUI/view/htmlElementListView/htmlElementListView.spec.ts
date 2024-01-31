import { ComponentFixture, TestBed } from '@angular/core/testing';

import { HtmlElementListView } from './htmlElementListView';

describe('HtmlElementListViewComponent', () => {
  let component: HtmlElementListView;
  let fixture: ComponentFixture<HtmlElementListView>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [HtmlElementListView]
    });
    fixture = TestBed.createComponent(HtmlElementListView);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
