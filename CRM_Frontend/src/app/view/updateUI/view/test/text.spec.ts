import { ComponentFixture, TestBed } from '@angular/core/testing';

import { Text } from './text';

describe('HtmlElementListViewComponent', () => {
  let component: Text;
  let fixture: ComponentFixture<Text>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [Text]
    });
    fixture = TestBed.createComponent(Text);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
