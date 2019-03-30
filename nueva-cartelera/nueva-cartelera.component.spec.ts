import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { NuevaCarteleraComponent } from './nueva-cartelera.component';

describe('NuevaCarteleraComponent', () => {
  let component: NuevaCarteleraComponent;
  let fixture: ComponentFixture<NuevaCarteleraComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ NuevaCarteleraComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(NuevaCarteleraComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
