import { NgModule, CUSTOM_ELEMENTS_SCHEMA } from '@angular/core'
import { RouterModule } from '@angular/router'
import { CommonModule } from '@angular/common'

import { ComponentsModule } from '../components/components.module'
import { LoginComponent } from './login.component'
import { FormsModule } from '@angular/forms'

const routes = [
  {
    path: '',
    component: LoginComponent,
  },
]

@NgModule({
  declarations: [LoginComponent],
  imports: [CommonModule, ComponentsModule, RouterModule.forChild(routes), FormsModule],
  exports: [LoginComponent],
  schemas: [CUSTOM_ELEMENTS_SCHEMA],
})
export class LoginModule {}
