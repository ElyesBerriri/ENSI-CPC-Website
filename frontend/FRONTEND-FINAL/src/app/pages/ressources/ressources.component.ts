import { Component } from '@angular/core'
import { Title, Meta } from '@angular/platform-browser'

@Component({
  selector: 'app-ressources',
  templateUrl: 'ressources.component.html',
  styleUrls: ['ressources.component.css'],
})
export class Ressources {
  rawohdu: string = ' '
  rawulxr: string = ' '
  raw9u8r: string = ' '
  rawt7ph: string = ' '
  rawwgat: string = ' '
  rawnssj: string = ' '
  rawp0po: string = ' '
  rawph9d: string = ' '
  rawtobr: string = ' '
  raw8rq7: string = ' '
  constructor(private title: Title, private meta: Meta) {
    this.title.setTitle('ressources - Character NFT template')
    this.meta.addTags([
      {
        property: 'og:title',
        content: 'ressources - Character NFT template',
      },
    ])
  }
}
