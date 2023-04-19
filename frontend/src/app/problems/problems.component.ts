import { HttpClient } from '@angular/common/http';
import { Component } from '@angular/core';

@Component({
  selector: 'app-problems',
  templateUrl: './problems.component.html',
  styleUrls: ['./problems.component.css']
})
export class ProblemsComponent {
  array:Array<any>=[];
  constructor(private http: HttpClient)  {}
  ngOnInit(): void {
    //let id=this.route.snapshot.paramMap.get('id');
    //console.log(id);
    this.http.get("//localhost:8080/problems/all").subscribe(
      (res)=>{
        console.log(res);
        this.array=JSON.parse(JSON.stringify(res));
        console.log(this.array)
      }
      
    )
    
  }

}
