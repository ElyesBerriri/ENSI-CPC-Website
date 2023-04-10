import { Component } from '@angular/core'
import { Title, Meta } from '@angular/platform-browser'

@Component({
  selector: 'app-resources',
  templateUrl: 'resources.component.html',
  styleUrls: ['resources.component.css'],
})
export class Resources {
  constructor(private title: Title, private meta: Meta) {
    this.title.setTitle('resources - Character NFT template')
    this.meta.addTags([
      {
        property: 'og:title',
        content: 'resources - Character NFT template',
      },
    ])
  }
}
