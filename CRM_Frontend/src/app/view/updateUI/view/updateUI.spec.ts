import { ComponentFixture, TestBed } from '@angular/core/testing';

import { UpdateUI } from './updateUI';

describe('TestComponent', () => {
  let component: UpdateUI;
  let fixture: ComponentFixture<UpdateUI>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ UpdateUI ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(UpdateUI);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
