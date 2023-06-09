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
    editor.getSession().setMode("ace/mode/c_cpp");
    //here you choose the programming language
    const lang="python3";
    var code = editor.getValue();
    //format for jdoodle
    var formattedCode = JSON.stringify(code)
    .replace(/\n/g, '\\\\n')
    .replace(/\r/g, '')
    .replace(/\\r/g, '');
    var cpte="num = int(input())\\nprint(num)\\n"
    formattedCode = formattedCode.substring(1);
    formattedCode=formattedCode.slice(0, -1);
    console.log(formattedCode)
    this.authService.pb(lang,formattedCode,8).subscribe(
      data => {
        console.log(data);
      },
      err => {
        console.log(err)
;      }
    );
  }
}

