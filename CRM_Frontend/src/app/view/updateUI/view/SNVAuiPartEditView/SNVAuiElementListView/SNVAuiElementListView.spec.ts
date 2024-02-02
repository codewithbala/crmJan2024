import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SNVAuiElementListView } from './SNVAuiElementListView';

describe('SNVAuiElementListViewComponent', () => {
  let component: SNVAuiElementListView;
  let fixture: ComponentFixture<SNVAuiElementListView>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [SNVAuiElementListView]
    });
    fixture = TestBed.createComponent(SNVAuiElementListView);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
