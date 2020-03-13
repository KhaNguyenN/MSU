%Creates a blank white image of 256x256
blankimage = ones(256,256,1);
blankimage(:,:,1) = .7; %sets the intensity to .7

for i=1:256
    for j=1:256
        if round(sqrt((i-128)^2+(j-128)^2))< 80 %crop the circle
        blankimage(i,j) = .4; %sets the intensity of the circle to .4
        end      
    end
end
 figure, imshow(blankimage);
colormap(gray(256));
im = double(blankimage);
im(256,256,1) = im(128,128,1)*.7
figure, imshow(im);
   
% 
% out_impath=[path,'output/','Original.jpg'];
% imwrite(im,out_impath);
%Gaussian noise
im1 = imnoise(im, 'gaussian');
figure, imshow(im1);
h = histogram(im1);
histogram(im1);
img1= conv2(double(im1), ones(3)/9, 'same');
figure, imshow(img1);
%Saving the images%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
% % out_impath=[path,'output/','Gaussian.jpg'];
% % imwrite(im1,out_impath);
% out_impath=[path,'output/','filteredG.jpg'];
% imwrite(img1,out_impath);

%Uniform noise
A = -0.05;%lower bound
B = 0.05;%upper bound
matrix_uniform = A + (B-A)*rand(size(im));
im2 = im + matrix_uniform;
figure, imshow(im2);
h2 = imhist(im2);
imhist(im2);
filter = fspecial('average',3);
img2 = imfilter(im2,filter,'same');
figure, imshow(img2);
%Saving the images%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
% out_impath=[path,'output/','Uniform.jpg'];
% imwrite(im2,out_impath);
% out_impath=[path,'output/','filteredU.jpg'];
% imwrite(img2,out_impath);

%Salt and pepper noise
im3=imnoise(im,'salt & pepper',0.02);
figure, imshow(im3);
h3 = imhist(im3);
imhist(im3);
img3 = medfilt2(im3);
figure, imshow(img3);
%Saving the images%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
% out_impath=[path,'output/','Salt&Pepper.jpg'];
% imwrite(im3,out_impath);
% out_impath=[path,'output/','filteredSP.jpg'];
% imwrite(img3,out_impath);
