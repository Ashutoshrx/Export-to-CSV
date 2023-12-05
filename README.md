# Export-to-CSV
## Exporting to CSV using OpenCSV and Aparche Common CSV using a generic class.
##A quick differentiation between OpenCsv And Common Csv.


          **Aparche Common CSV	**                                                                         **OpenCsv**
_Headers can be read from Properties file.(A little easier than OpenCsv)	            Headers can be read from Properties file.
Custom Column Ordering is not possible.(default-attributes' name order)	            Custom Column Ordering is possible.(default- ascending order sorted)
Sheet name manipulation is not possible.	                                          Sheet name manipulation is not possibe.
If a cell is null, we can set custom value,i.e-'~'	                                The cell will be empty_.









For Reference-
https://stackoverflow.com/questions/45203867/opencsv-how-to-create-csv-file-from-pojo-with-custom-column-headers-and-custom
