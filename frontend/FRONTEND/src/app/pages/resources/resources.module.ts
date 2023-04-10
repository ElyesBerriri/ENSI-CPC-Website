import { NgModule, CUSTOM_ELEMENTS_SCHEMA } from '@angular/core'
import { RouterModule } from '@angular/router'
import { CommonModule } from '@angular/common'

import { ComponentsModule } from '../../components/components.module'
import { Resources } from './resources.component'

const routes = [
  {
    path: '',
    component: Resources,
  },
]

@NgModule({
  declarations: [Resources],
  imports: [CommonModule, ComponentsModule, RouterModule.forChild(routes)],
  exports: [Resources],
  schemas: [CUSTOM_ELEMENTS_SCHEMA],
})
export class ResourcesModule {}
