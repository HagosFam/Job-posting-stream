import { Directive, ElementRef, Input, OnChanges, SimpleChange, SimpleChanges } from '@angular/core';

@Directive({
  selector: '[appFlashOnChange]'
})
export class FlashOnChangeDirective implements OnChanges {

  @Input('appFlashOnChange') dataItem: any;
  @Input()field!: string;
  previousValue: any;

  constructor(private el: ElementRef) { }

  ngOnChanges(changes: SimpleChanges) {
    let simpleChange = changes['dataItem']['currentValue'];
    if (simpleChange && simpleChange.count !== this.previousValue) {
      this.el.nativeElement.classList.add('flash');
      setTimeout(() => this.el.nativeElement.classList.remove('flash'), 1000);
      this.previousValue = simpleChange.count;
    }
  }
}
