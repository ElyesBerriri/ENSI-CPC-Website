
import { ActivatedRoute } from '@angular/router';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { AfterViewInit, Component, ElementRef, ViewChild } from '@angular/core';
import * as ace from 'ace-builds';
import { environment } from 'src/environments/environment';
import { AuthService } from '../_services/auth.service';
const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};
@Component({
  selector: 'app-problem',
  templateUrl: './problem.component.html',
  styleUrls: ['./problem.component.css']
})
export class ProblemComponent implements AfterViewInit {
  @ViewChild('editor') editorRef!: ElementRef;
  pb_id:number;
  pb:any;
  flag:boolean;
  
  constructor(private http: HttpClient,private route:ActivatedRoute,private authService: AuthService) {
    this.pb_id = Number(this.route.snapshot.paramMap.get('id'));
    this.flag=false;
  }
  ngOnInit(): void {
    let id=this.route.snapshot.paramMap.get('id');
    this.http.get("http://localhost:8080/problems/find/"+id).subscribe(
      (res)=>{
        console.log(res);
        this.pb=res;
        console.log(this.pb)
      }
      
    )
    
  }
  ngAfterViewInit() {
    const editor = ace.edit(this.editorRef.nativeElement);
    editor.setTheme('ace/theme/monokai');
    editor.getSession().setMode('ace/mode/javascript');
  }
  showValue(): void {
    const editor = ace.edit(this.editorRef.nativeElement);
    editor.getSession().setMode("ace/mode/c_cpp");
    //const lines = editor.getValue().split("\n");
    //const textWithNewlines = lines.join("\n") + "\\n"; // join the lines with "\n" and add a trailing "\n"
    //console.log(textWithNewlines);
    const lang="python3";
    var code = editor.getValue();
    
    var formattedCode = JSON.stringify(code)
    .replace(/\n/g, '\\\\n')
    .replace(/\r/g, '')
    .replace(/\\r/g, '');
    var cpte="num = int(input())\\nprint(num)\\n"
    formattedCode = formattedCode.substring(1);
    formattedCode=formattedCode.slice(0, -1);
    console.log(formattedCode)
    this.authService.pb(lang,formattedCode,this.pb_id).subscribe(
      data => {
        console.log(data);
        this.flag=data;
      },
      err => {
        console.log(err)
;      }
    );
  }
  
}
