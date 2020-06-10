import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { UpdatescheduledflightComponent } from './updatescheduledflight.component';

describe('UpdatescheduledflightComponent', () => {
  let component: UpdatescheduledflightComponent;
  let fixture: ComponentFixture<UpdatescheduledflightComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ UpdatescheduledflightComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(UpdatescheduledflightComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
