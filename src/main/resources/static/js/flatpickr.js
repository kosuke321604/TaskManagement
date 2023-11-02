let maxDate = new Date();
 maxDate = maxDate.setMonth(maxDate.getMonth() + 3);
 
 flatpickr('#deadlineDate', {

   locale: 'ja',
   minDate: 'today',
   maxDate: maxDate
 });
 
 flatpickr('#doneDate', {
  
   locale: 'ja',
   minDate: 'today',
   maxDate: maxDate
 });