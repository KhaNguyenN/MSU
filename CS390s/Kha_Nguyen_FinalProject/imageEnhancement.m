clc
clear all
close all 

[file,path] = uigetfile('./Image_Folder/',...
                         'Select an Image File')

colorImage=imread(fullfile(path,file));
figure,imshow(colorImage); % you could also try image() imagesc() other image display functions 

%Averaging Filter
avgR1 = [1 1 1 
         1 1 1
         1 1 1]/9; 
imgFiltered = imfilter(colorImage,avgR1,'same');
figure, imshow(imgFiltered);

%Light up the image
AInv = imcomplement(imgFiltered);
figure, imshow(AInv);

BInv = imreducehaze(AInv);
figure, imshow(BInv);

B = imcomplement(BInv);

figure, montage({colorImage, B});

out_impath=[path,'\Output\','B.png'];% path of the output
imwrite(B,out_impath);

A = B;
A = imresize(A,0.25);
Agray = rgb2gray(A);
figure
imshow(A)

imageSize = size(A);
numRows = imageSize(1);
numCols = imageSize(2);

wavelengthMin = 4/sqrt(2);
wavelengthMax = hypot(numRows,numCols);
n = floor(log2(wavelengthMax/wavelengthMin));
wavelength = 2.^(0:(n-2)) * wavelengthMin;

deltaTheta = 45;
orientation = 0:deltaTheta:(180-deltaTheta);

g = gabor(wavelength,orientation);

gaborMag = imgaborfilt(Agray,g);

for i = 1:length(g)
    sigma = 0.5*g(i).Wavelength;
    K = 3;
    gaborMag(:,:,i) = imgaussfilt(gaborMag(:,:,i),K*sigma); 
end

X = 1:numCols;
Y = 1:numRows;
[X,Y] = meshgrid(X,Y);
featureSet = cat(3,gaborMag,X);
featureSet = cat(3,featureSet,Y);

numPoints = numRows*numCols;
X = reshape(featureSet,numRows*numCols,[]);

X = bsxfun(@minus, X, mean(X));
X = bsxfun(@rdivide,X,std(X));

coeff = pca(X);
feature2DImage = reshape(X*coeff(:,1),numRows,numCols);
figure
imshow(feature2DImage,[])

L = kmeans(X,2,'Replicates',5);

L = reshape(L,[numRows numCols]);
figure
imshow(label2rgb(L))

Aseg1 = zeros(size(A),'like',A);
Aseg2 = zeros(size(A),'like',A);
BW = L == 2;
BW = repmat(BW,[1 1 3]);
Aseg1(BW) = A(BW);
Aseg2(~BW) = A(~BW);
figure
imshowpair(Aseg1,Aseg2,'montage');

out_impath=[path,'\Output\','Aseg2.png'];% path of the output
imwrite(Aseg2,out_impath);
out_impath=[path,'\Output\','Aseg1.png'];% path of the output
imwrite(Aseg1,out_impath);

