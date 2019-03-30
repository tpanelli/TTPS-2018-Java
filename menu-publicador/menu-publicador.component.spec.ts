import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { MenuPublicadorComponent } from './menu-publicador.component';

describe('MenuPublicadorComponent', () => {
  let component: MenuPublicadorComponent;
  let fixture: ComponentFixture<MenuPublicadorComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ MenuPublicadorComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(MenuPublicadorComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
