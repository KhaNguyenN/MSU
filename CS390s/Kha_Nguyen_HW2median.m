%Median Filter
orginal = imread('./Image_Folder/RedFlower.jpg');
red = rgb2gray(orginal);
red=imnoise(red,'salt & pepper',0.02);
red = double(red);
red1=red;
colormap(gray(256));
figure,
imagesc(im);
axis image;
axis off;
medianKernel = [1 1 1
          1 1 1
          1 1 1]/8;
      
for i=2:size(red,1)-1
    for j=2:size(red,2)-1
tp=red(i-1:i+1,j-1:j+1);
red1(i,j)=median(tp(:));
    end
end

imgMedianFiltered = imfilter(red,medianKernel,'same');
figure, imagesc(abs(imgMedianFiltered));
title('Median Filtered Image');
out_impath=[path,'output/','MedianFiltered.jpg'];% path of the output im
imwrite(imgMedianFiltered,out_impath);