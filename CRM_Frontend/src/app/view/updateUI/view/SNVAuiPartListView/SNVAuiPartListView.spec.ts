import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SNVAuiPartListView } from './SNVAuiPartListView';

describe('SNVAuiPartListViewComponent', () => {
  let component: SNVAuiPartListView;
  let fixture: ComponentFixture<SNVAuiPartListView>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [SNVAuiPartListView]
    });
    fixture = TestBed.createComponent(SNVAuiPartListView);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
