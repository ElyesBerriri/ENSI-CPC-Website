import { NgModule, CUSTOM_ELEMENTS_SCHEMA } from '@angular/core'
import { RouterModule } from '@angular/router'
import { CommonModule } from '@angular/common'

import 'dangerous-html'

import { ComponentsModule } from '../../components/components.module'
import { Ressources } from './ressources.component'

const routes = [
  {
    path: '',
    component: Ressources,
  },
]

@NgModule({
  declarations: [Ressources],
  imports: [CommonModule, ComponentsModule, RouterModule.forChild(routes)],
  exports: [Ressources],
  schemas: [CUSTOM_ELEMENTS_SCHEMA],
})
export class RessourcesModule {}
