import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule } from '@angular/common/http';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import {MatTableModule} from '@angular/material/table';
import {MatGridListModule} from '@angular/material/grid-list';

import {MatPaginator} from '@angular/material/paginator';
import {MatTableDataSource} from '@angular/material/table';
import { MaterialTemplateModule } from 'src/material.module';
import { FlashOnChangeDirective } from './flash-on-change.directive';


@NgModule({
  declarations: [
    AppComponent,
    FlashOnChangeDirective
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    MaterialTemplateModule

  ],
  exports: [MatGridListModule],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
