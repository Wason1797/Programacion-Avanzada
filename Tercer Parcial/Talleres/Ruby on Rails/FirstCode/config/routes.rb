Rails.application.routes.draw do
  resources :articles
  get 'wellcome/index'
  # For details on the DSL available within this file, see http://guides.rubyonrails.org/routing.html
  #root to: 
end
