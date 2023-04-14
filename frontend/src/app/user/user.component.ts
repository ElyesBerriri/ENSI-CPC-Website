import { HttpClient, HttpHeaders } from '@angular/common/http';
import { AfterViewInit, Component, ElementRef, ViewChild } from '@angular/core';
import * as ace from 'ace-builds';
import { environment } from 'src/environments/environment';
import { AuthService } from '../_services/auth.service';
const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};

@Component({
  selector: 'app-user',
  templateUrl: './user.component.html',
  styleUrls: ['./user.component.css']
})
export class UserComponent implements AfterViewInit {
  @ViewChild('editor') editorRef!: ElementRef;

  private apiServerUrl = environment.apiBaseUrl;

    constructor(private authService: AuthService){}
  ngAfterViewInit() {
    const editor = ace.edit(this.editorRef.nativeElement);
    editor.setTheme('ace/theme/monokai');
    editor.getSession().setMode('ace/mode/javascript');
  }
  showValue(): void {
    const editor = ace.edit(this.editorRef.nativeElement);
    //const lines = editor.getValue().split("\n");
    //const textWithNewlines = lines.join("\n") + "\\n"; // join the lines with "\n" and add a trailing "\n"
    //console.log(textWithNewlines);
    const lang="cpp";
    var code = editor.getValue();
    var formattedCode = JSON.stringify(code)
    .replace(/\n/g, '\\\\n')
    .replace(/\r/g, '')
    .replace(/\\r/g, '');
    var cpte="#include <iostream>\\n\\nusing namespace std;\\n\\nint main() {\\nint a;\\nstd::cin>>a;\\nstd::cout<<a;\\n}"
    formattedCode = formattedCode.substring(1);
    formattedCode=formattedCode.slice(0, -1);
    console.log(formattedCode)
    this.authService.pb(lang,formattedCode).subscribe(
      data => {
        console.log(data);
      },
      err => {
        console.log(err)
;      }
    );
  }
}

