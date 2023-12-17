# Use an official lightweight Node.js image
FROM node:alpine

# Set the working directory in the container
WORKDIR /app

# Copy package.json and package-lock.json to the working directory
COPY package*.json ./

# Install dependencies
RUN npm install

# Copy the index.html file to the working directory
COPY index.html .

# Expose port 80
EXPOSE 80

# Start the application
CMD ["npm", "start"]