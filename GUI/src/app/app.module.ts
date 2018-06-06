import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { TaskServiceService } from './services/task-service.service';
import { TaskTileComponent } from './home/task-tile/task-tile.component';
import { WeatherTileComponent } from './home/weather-tile/weather-tile.component';
import { FinanceTileComponent } from './home/finance-tile/finance-tile.component';
import { NewsTileComponent } from './home/news-tile/news-tile.component';

@NgModule({
  declarations: [
    AppComponent,
    TaskTileComponent,
    WeatherTileComponent,
    FinanceTileComponent,
    NewsTileComponent
  ],
  imports: [
    BrowserModule
  ],
  providers: [
    TaskServiceService
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
